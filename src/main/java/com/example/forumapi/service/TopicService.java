package com.example.forumapi.service;

import com.example.forumapi.dto.MessageDTO;
import com.example.forumapi.dto.TopicDTO;
import com.example.forumapi.model.Message;
import com.example.forumapi.model.Topic;
import com.example.forumapi.model.User;
import com.example.forumapi.repos.MessageRepository;
import com.example.forumapi.repos.TopicRepository;
import com.example.forumapi.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepository topicRepo;
    private final UserRepository userRepo;
    private final MessageRepository messageRepo;

    public TopicDTO postTopic(int userId, int forumId, String name,String text){
        Topic topic=new Topic(0,name,userId,forumId,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),1);
        topic = topicRepo.save(topic);
        Message message=new Message(0,text,userId,topic.getId(),new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));
        message=messageRepo.save(message);
        List<Message> messages=new ArrayList<>();
        messages.add(message);
        Optional<User> user=userRepo.findById(userId);
        user.get().setNrOfTopics(user.get().getNrOfTopics()+1);
        userRepo.save(user.get());
        return new TopicDTO(topic,userRepo.findById(topic.getUserId()).get(),dtoIze(messages));
    }

    public List<Topic> getTopicsByUser(int userId){
        return (List<Topic>)topicRepo.findAllByUserId(userId);
    }

    public TopicDTO getTopic(int id){
        Optional<Topic> topic=topicRepo.findById(id);
        if(topic.isEmpty())
            return null;
        return new TopicDTO(topic.get(),userRepo.findById(topic.get().getUserId()).get(),dtoIze((List<Message>)messageRepo.findAllByTopicId(topic.get().getId())));
    }

    List<MessageDTO> dtoIze(List<Message> messages){
        List<MessageDTO> messagesDTO=new ArrayList<>();
        for(Message message:messages){
            messagesDTO.add(new MessageDTO(message,userRepo.findById(message.getUserId()).get()));
        }
        return messagesDTO;
    }

    List<TopicDTO> dtoIze2(Iterable<Topic> topics){
        List<TopicDTO> topicsDTO=new ArrayList<>();
        for(Topic topic:topics){
            topicsDTO.add(new TopicDTO(topic,userRepo.findById(topic.getUserId()).get(),null));
        }
        return topicsDTO;
    }
}
