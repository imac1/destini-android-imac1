package com.londonappbrewery.destini;

public class storyAndAnswers {
    private int storyId;
    private int answerId1;
    private  int answerId2;

    // create the constructor

    public storyAndAnswers(int storyText, int answer1, int answer2) {
       storyId = storyText;
        answerId1 = answer1;
        answerId2 = answer2;
    }

    // methods to retrieve story and answers
    public int getStoryId (){
        return storyId;
    }

    public int getAnswerId1() {
        return answerId1;
    }

    public int getAnswerId2() {
        return answerId2;
    }
}
