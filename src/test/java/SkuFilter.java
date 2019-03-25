import Enums.BasedUrls;
import Enums.PathSegment;
import Enums.UrlParams;
import skuJsonObject.TableObject;
import urlWork.SkuUrl;
import workWithFile.FileWork;

import java.util.ArrayList;
import java.util.List;

public class SkuFilter {

    public static void main(String[] args) {
        SkuUrl url = new SkuUrl();
        TableObject tableObject = new TableObject();
        ArrayList<String> table = FileWork.readingFile("C:\\Users\\Yaros\\IdeaProjects\\LearningJava\\sku_in_store_is_deliverable1.table");
        List<String> list = FileWork.getFilteredData(table, "IsOfSourceFilter$");
        List<String> parsedList = url.getListOfSkuWithLenght(list, 50);
        List<String> urlList = url.getCreatedUrl(BasedUrls.BASE_URL_UAT, PathSegment.PRICE_AVAILABILITY, parsedList, UrlParams.BANNER_CTR, UrlParams.IS_KIOSK, UrlParams.LANGUAGE_ENGLISH, UrlParams.STORE_0987);
        List<TableObject> filteredList = url.httpGetRequest(urlList);
        String filteredData = tableObject.quantityFilterScu(filteredList, "0");


        //        ArrayList<String> table1 = FileWork.readingFile("C:\\Users\\Yaros\\Desktop\\CTC\\mobc.txt");
//        List<String> list1 = FileWork.getFilteredData(table1, "^([A-Z]*[-][0-9 ]*)");
//        FileWork.writeToFile(list1.toString(),"C:\\Users\\Yaros\\Desktop\\CTC\\mobc1.txt");
//

    }
}
