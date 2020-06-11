package model.entities;
import java.util.ArrayList;
import lombok.*;
import lombok.Builder;


// *** Builder design pattern *** // 
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private Member clubMember;
    private ArrayList<Item> item;
    private int price;
    private int shoppingRating;

}
