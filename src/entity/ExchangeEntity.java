package entity;

import javax.persistence.*;

/**
 * Created by Mezereon on 2017/10/8.
 */
@Entity
@Table(name = "exchange", schema = "mezereon")
public class ExchangeEntity {
    private int id;
    private String usernamea;
    private String usernameb;
    private String date;
    private String bookida;
    private String bookidb;
    private String booksrca;
    private String booksrcb;
    private int status;
    private String booknamea;
    private String booknameb;
    private String numbera;
    private String numberb;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "usernamea", nullable = false, length = 90)
    public String getUsernamea() {
        return usernamea;
    }

    public void setUsernamea(String usernamea) {
        this.usernamea = usernamea;
    }

    @Basic
    @Column(name = "usernameb", nullable = false, length = 90)
    public String getUsernameb() {
        return usernameb;
    }

    public void setUsernameb(String usernameb) {
        this.usernameb = usernameb;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 50)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "bookida", nullable = false, length = 40)
    public String getBookida() {
        return bookida;
    }

    public void setBookida(String bookida) {
        this.bookida = bookida;
    }

    @Basic
    @Column(name = "bookidb", nullable = false, length = 40)
    public String getBookidb() {
        return bookidb;
    }

    public void setBookidb(String bookidb) {
        this.bookidb = bookidb;
    }

    @Basic
    @Column(name = "booksrca", nullable = false, length = 90)
    public String getBooksrca() {
        return booksrca;
    }

    public void setBooksrca(String booksrca) {
        this.booksrca = booksrca;
    }

    @Basic
    @Column(name = "booksrcb", nullable = false, length = 90)
    public String getBooksrcb() {
        return booksrcb;
    }

    public void setBooksrcb(String booksrcb) {
        this.booksrcb = booksrcb;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "booknamea", nullable = false, length = 90)
    public String getBooknamea() {
        return booknamea;
    }

    public void setBooknamea(String booknamea) {
        this.booknamea = booknamea;
    }

    @Basic
    @Column(name = "booknameb", nullable = false, length = 90)
    public String getBooknameb() {
        return booknameb;
    }

    public void setBooknameb(String booknameb) {
        this.booknameb = booknameb;
    }

    @Basic
    @Column(name = "numbera", nullable = false, length = 25)
    public String getNumbera() {
        return numbera;
    }

    public void setNumbera(String numbera) {
        this.numbera = numbera;
    }

    @Basic
    @Column(name = "numberb", nullable = false, length = 25)
    public String getNumberb() {
        return numberb;
    }

    public void setNumberb(String numberb) {
        this.numberb = numberb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeEntity that = (ExchangeEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (usernamea != null ? !usernamea.equals(that.usernamea) : that.usernamea != null) return false;
        if (usernameb != null ? !usernameb.equals(that.usernameb) : that.usernameb != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (bookida != null ? !bookida.equals(that.bookida) : that.bookida != null) return false;
        if (bookidb != null ? !bookidb.equals(that.bookidb) : that.bookidb != null) return false;
        if (booksrca != null ? !booksrca.equals(that.booksrca) : that.booksrca != null) return false;
        if (booksrcb != null ? !booksrcb.equals(that.booksrcb) : that.booksrcb != null) return false;
        if (booknamea != null ? !booknamea.equals(that.booknamea) : that.booknamea != null) return false;
        if (booknameb != null ? !booknameb.equals(that.booknameb) : that.booknameb != null) return false;
        if (numbera != null ? !numbera.equals(that.numbera) : that.numbera != null) return false;
        if (numberb != null ? !numberb.equals(that.numberb) : that.numberb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (usernamea != null ? usernamea.hashCode() : 0);
        result = 31 * result + (usernameb != null ? usernameb.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (bookida != null ? bookida.hashCode() : 0);
        result = 31 * result + (bookidb != null ? bookidb.hashCode() : 0);
        result = 31 * result + (booksrca != null ? booksrca.hashCode() : 0);
        result = 31 * result + (booksrcb != null ? booksrcb.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (booknamea != null ? booknamea.hashCode() : 0);
        result = 31 * result + (booknameb != null ? booknameb.hashCode() : 0);
        result = 31 * result + (numbera != null ? numbera.hashCode() : 0);
        result = 31 * result + (numberb != null ? numberb.hashCode() : 0);
        return result;
    }
}
