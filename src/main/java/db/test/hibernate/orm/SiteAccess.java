package db.test.hibernate.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by karol on 04.12.14.
 */
//@Entity
//@Table(name = "SiteAccess")
public class SiteAccess  {
    @Id
    @Column(name = "site_id")
    private Integer siteId;
    @Id
    @Column(name = "user_id")
    private Integer userId;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
