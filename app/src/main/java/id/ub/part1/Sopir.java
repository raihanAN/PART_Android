package id.ub.part1;

public class Sopir {

    private String key;
    private String name;
    private String usia;
    private String gaji;
    private String skill;
    private String domisili;
    private String descript;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
    public Sopir (){}
    public Sopir(String name, String usia, String gaji, String skill, String domisili, String descript) {
        this.name = name;
        this.usia = usia;
        this.gaji = gaji;
        this.skill = skill;
        this.domisili = domisili;
        this.descript = descript;
    }
}
