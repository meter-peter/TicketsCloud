package meter_peter.ticketscloud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class DVD {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String genre;
    private int quantity;

    public DVD(UUID id, String title, String genre, int quantity) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.quantity = quantity;
    }

    public DVD() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
