package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO;

/**
 * Created by kwakgee on 2017. 9. 21..
 */

public class ReplyVO_Post {

    private String content;
    private String player;

    public ReplyVO_Post(String content, String player) {
        this.content = content;
        this.player = player;
    }

    public String getContent() {
        return content;
    }

    public String getPlayer() {
        return player;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
