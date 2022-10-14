package com.reto3.usa.service;

import com.reto3.usa.daoRepository.ScoreRepository;
import com.reto3.usa.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
     public List<Score>getAll(){
        return scoreRepository.getAll();               
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        } else {     
            Optional<Score>scoreEncontrado=getScore(score.getIdScore());
            if(scoreEncontrado.isEmpty()){
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score>scoreEncontrado=getScore(score.getIdScore());
            if(!scoreEncontrado.isEmpty()){
               if(score.getMessageText()!=null){
                   scoreEncontrado.get().setMessageText(score.getMessageText());
               }                
               if(score.getStars()!=null){
                   scoreEncontrado.get().setStars(score.getStars());
               }
               return scoreRepository.save(scoreEncontrado.get());
            }
        }
        return score;
    }
    public boolean deleteScore(int id){
        Boolean resultado = getScore(id).map(scorePorEliminar ->{
            scoreRepository.delete(scorePorEliminar);
            return true;
    }).orElse(false);
    return resultado;
    }
}