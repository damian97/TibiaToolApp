package org.TibiaApp;

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
}
