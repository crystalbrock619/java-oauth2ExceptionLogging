package com.lambdaschool.authenticatedusers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name = "quotes")
public class Quote extends Auditable
{
    private static final Logger logger = LoggerFactory.getLogger(Quote.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long quotesid;

    @Column(nullable = false)
    private String quote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties({"quotes", "hibernateLazyInitializer"})
    private User user;

    public Quote()
    {
        logger.info("Creating a Quote " + this);
    }

    public Quote(String quote, User user)
    {
        this.quote = quote;
        this.user = user;

        logger.info("Creating a Quote " + this);
    }

    public long getQuotesid()
    {
        return quotesid;
    }

    public void setQuotesid(long quotesid)
    {
        this.quotesid = quotesid;
    }

    public String getQuote()
    {
        return quote;
    }

    public void setQuote(String quote)
    {
        this.quote = quote;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Quote{" + "quotesid=" + quotesid + ", quote='" + quote + '\'' + ", user=" + user + '}';
    }
}