/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.entity;

import java.util.List;
 
public class Board {
 
    private DiscussionForum dis;
    private List<Message> messagelist;

    /**
     * @return the dis
     */
    public DiscussionForum getDis() {
        return dis;
    }

    /**
     * @param dis the dis to set
     */
    public void setDis(DiscussionForum dis) {
        this.dis = dis;
    }

    /**
     * @return the messagelist
     */
    public List<Message> getMessagelist() {
        return messagelist;
    }

    /**
     * @param messagelist the messagelist to set
     */
    public void setMessagelist(List<Message> messagelist) {
        this.messagelist = messagelist;
    }
}
