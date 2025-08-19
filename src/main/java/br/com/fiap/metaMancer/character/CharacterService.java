package br.com.fiap.metaMancer.character;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository){

        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters(){
        List<Character> characters = characterRepository.findAll();
        System.out.println("Character list: " + characters);  // Ou usar um logger, se preferir
        return characterRepository.findAll();
    }

    public Character save(Character character){
        return characterRepository.save(character);
    }
}
