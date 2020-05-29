package com.kahlua.web.proxy;

import com.kahlua.web.music.Music;
import com.kahlua.web.music.MusicRepository;
import com.kahlua.web.soccer.Player;
import com.kahlua.web.soccer.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service("uploader") @Lazy
public class FileUploader extends Proxy{
    @Autowired Inventory<String> inventory;
    @Autowired PlayerRepository repository;
    @Autowired MusicRepository musicRepository;
    @Autowired Crawler crawler;

    public void upload() {
        inventory.clear();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bit\\IdeaProjects\\kahlua\\src\\main\\resources\\static\\files\\player.csv"));
            String player = "";
            while ((player = reader.readLine()) != null) {
                inventory.add(player);
            }
        } catch (Exception e){
            print("file reading error :(");
            e.printStackTrace();
        }
//        for(String s : inventory.get()){
//            String[] arr = s.split(",");
//            player.set
//        }
        print("-----------------------------------\n");
        print(inventory.get().get(0).toString());
        String[] arr = inventory.get().get(0).toString().split(",");
        Player p = new Player();
        p.setPlayerId(arr[0]);
        p.setPlayerName(arr[1]);
        p.setePlayerName(arr[3]);
        p.setNickName(arr[4]);
        p.setJoinYyyy(arr[5]);
        p.setPosition(arr[6]);
        p.setBackNo(arr[7]);
        p.setNation(arr[8]);
        p.setBirthDate(arr[9]);
        p.setSolar(arr[10]);
        p.setHeight(arr[11]);
        p.setWeight(arr[12]);
        print("*************************************\n");
        print(p.toString());
        repository.save(p);
    }
/*
    public void chartUpload() {

        print(inventory.get().get(0).toString());
        String[] arr = inventory.get().get(0).toString().split(",");
        Music chart = new Music();
        chart.setSeq(arr[0]);
        chart.setTitle(arr[1]);
        chart.setArtists(arr[2]);
        chart.setThumbnail(arr[3]);
        print("********************************\n");
        print(chart.toString());
        musicRepository.save(chart);
    }
*/

}
