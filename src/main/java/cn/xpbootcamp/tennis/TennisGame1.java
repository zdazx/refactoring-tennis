package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (m_score1 == m_score2) {
            score = getScoreWhenTwoScoreIsEqual();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getScoreAdvantage();
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = m_score1;
                else {
                    score.append("-");
                    tempScore = m_score2;
                }
                if (tempScore < 3) {
                    score.append(getMidScore(tempScore));
                } else if (tempScore == 3){
                    score.append("Forty");
                }
            }
        }
        return score.toString();
    }

    private StringBuilder getScoreAdvantage() {
        StringBuilder score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private StringBuilder getScoreWhenTwoScoreIsEqual() {
        StringBuilder score = new StringBuilder();
        if (m_score1 < 3) {
            score.append(getMidScore(m_score1));
            score.append("-All");
        } else {
            score = new StringBuilder("Deuce");
        }
        return score;
    }

    private String getMidScore(int value) {
        StringBuilder score = new StringBuilder();
        switch (value) {
            case 0:
                score = new StringBuilder("Love");
                break;
            case 1:
                score = new StringBuilder("Fifteen");
                break;
            case 2:
                score = new StringBuilder("Thirty");
                break;
        }
        return score.toString();
    }
}