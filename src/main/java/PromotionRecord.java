import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class PromotionRecord {
    private Hashtable<String, Promotion> promotionRecords = new Hashtable<>();

    public Hashtable<String, Promotion> getPromotionRecords() {
        return promotionRecords;
    }

    public int saveRecord(Promotion promotion){
        String id =  promotion.getPromotionId();
        if(promotionRecords.containsKey(id)){
            return 0;
        }
        promotionRecords.put(id, promotion);
        return 1;
    }

    public Promotion getRecord(String id)
    {
        if (promotionRecords.containsKey(id)){
            Promotion promotion = promotionRecords.get(id);
            return promotion;
        }
        return null;
    }

    public ArrayList<Promotion> getAllRecord()
    {
        ArrayList<Promotion> promotions = Collections.list(promotionRecords.elements());
        ;        return promotions;
    }

    public int updateRecord(String id, Promotion newRecord)
    {
        if (promotionRecords.containsKey(id)){
            promotionRecords.replace(id, newRecord);
            return 1;
        }
        return 0;
    }
    //DELETERECORD

    public static void main(String[] args){
        Promotion promotion1 = new Promotion(new StudentRecord(), "A2-2022", "A2");
        Promotion promotion2 = new Promotion(new StudentRecord(), "A3-2022", "A3");

        PromotionRecord record= new PromotionRecord();
        record.saveRecord(promotion1);
        record.saveRecord(promotion2);

        Promotion promotion = record.getRecord("A2-2022") ;
        System.out.println(promotion.getDescription());
        ArrayList<Promotion> promotions = record.getAllRecord();
    }
}
