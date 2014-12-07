package db.test.hibernate.orm;
import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by karol on 04.12.14.
 */
//@Entity
//@Table(name = "Site")
public class Site implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "site_id")
    private Integer id;
    @Column(name = "site_name")
    private String siteName;
    @Column(name = "siteCame")
    private String siteCode;

    public Site() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }
}
