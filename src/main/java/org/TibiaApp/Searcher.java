package org.TibiaApp;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Searcher {
    private String link;
    private String serverName;
    private int vocationId;
    private int skillId;
    private int pageIndex = 1;

    private int lvlStart, lvlStop;
    private int skillStart, skillStop;


    private Searcher() {
    }

    public Searcher(String serverName, int vocationId, int skillId, int lvlStart, int lvlStop, int skillStart, int skillStop) {
        this.serverName = serverName;
        this.vocationId = vocationId;
        this.skillId = skillId;
        this.lvlStart = lvlStart;
        this.lvlStop = lvlStop;
        this.skillStart = skillStart;
        this.skillStop = skillStop;
        setLink();
    }


    @Override
    public String toString() {
        return "Searcher{" +
                "link='" + link + '\'' +
                ", serverName='" + serverName + '\'' +
                ", vocationId=" + vocationId +
                ", skillId=" + skillId +
                ", lvlStart=" + lvlStart +
                ", lvlStop=" + lvlStop +
                ", skillStart=" + skillStart +
                ", skillStop=" + skillStop +
                '}';
    }

    public String getLink() {
        return link;
    }

    public void setLink() {
        this.link = "https://www.tibia.com/charactertrade/?subtopic=currentcharactertrades&" +
                "filter_profession=" + vocationId + "&" +
                "filter_levelrangefrom=" + lvlStart + "&" +
                "filter_levelrangeto=" + lvlStop + "&" +
                "filter_world=" + serverName + "&" +
                "filter_worldpvptype=9&" +
                "filter_worldbattleyestate=0&" +
                "filter_skillid=" + skillId + "&" +
                "filter_skillrangefrom=" + skillStart + "&" +
                "filter_skillrangeto=" + skillStop + "&" +
                "order_column=101&" +
                "order_direction=1&" +
                "searchtype=1&currentpage=" + pageIndex;
    }


    public String[] searchCharsNick() {
        Connection connect = Jsoup.connect(getLink());
        Document document = null;
        try {
            document = connect.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements allH1 = document.getElementsByClass("AuctionCharacterName");

        String[] tmpTable = new String[allH1.size()];
        for (int i = 0; i < allH1.size(); i++) {
            System.out.println(allH1.get(i).text());
            tmpTable[i] = allH1.get(i).text();
        }

        return tmpTable;
    }



    public String[] searchCharsLink() {
        Connection connect = Jsoup.connect(getLink());
        Document document = null;
        try {
            document = connect.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements allH2 = document.select("a");

        String[] tmpTable = new String[allH2.size()];

        for (int j = 0; j < allH2.size(); j++) {
            Element link = allH2.get(j);
            String href = link.attr("href");

            if (href.contains("page=details&auctionid=") && j % 2 == 0) {
                tmpTable[j] = href;
            }
        }

        int counter = 0;
        for (String x : tmpTable) {
            if (x != null) {
                counter++;
            }
        }

        String[] tmpTable1 = new String[counter];

        for (int i = 0, j = 0; i < tmpTable.length; i++) {
            if (tmpTable[i] != null) {
                tmpTable1[j] = tmpTable[i];
                j++;
            }

        }

        return tmpTable1;
    }


}
