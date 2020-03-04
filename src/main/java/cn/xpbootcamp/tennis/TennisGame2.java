package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";

    public TennisGame2() {
    }

    public String getScore() {
        String score = "";
        if (P1point == P2point && P1point < 4) {
            score = getPoint(P1point);
            score += "-All";
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            P1res = getPoint(P1point);
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point == 0) {
            P1res = "Love";
            P2res = getPoint(P2point);
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P1point < 4) {
            P1res = getPoint(P1point);
            P2res = getPoint(P2point);
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            P1res = getPoint(P1point);
            P2res = getPoint(P2point);
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public String getPoint(int point) {
        if (point == 0)
            return "Love";
        if (point == 1)
            return "Fifteen";
        if (point == 2)
            return "Thirty";
        if (point == 3)
            return "Forty";
        return "";
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}