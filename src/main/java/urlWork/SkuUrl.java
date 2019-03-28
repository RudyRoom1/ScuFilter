package urlWork;

import Enums.BasedUrls;
import Enums.PathSegment;
import Enums.UrlParams;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.response.Response;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import skuJsonObject.TableObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class SkuUrl {

    private SkuUrl param;

    private static String addItemsToList(int count, List<String> skuList) {
        List<String> sku = skuList.subList(0, count);
        String finalSku = String.join(",", sku);
        sku.clear();
        return finalSku;
    }

    public List<String> getCreatedUrl(BasedUrls basePage, PathSegment pathSegment, List<String> listOfElements, UrlParams... params) {
        List<String> listOfUrls = new ArrayList<>();
        for (String element : listOfElements) {
//            String urlBuilder = "";
            URIBuilder builder = new URIBuilder()
                    .setScheme("http")
                    .setHost(basePage.getBasedUrl())
                    .setPath(pathSegment.getPathSegment());

            Arrays.stream(params).forEach(entity ->
                    builder.setParameter(entity.getProperty(), entity.getValue()));

            try {
                listOfUrls.add(builder.build().toURL().toString().concat("&SKU=" + element));
            } catch (MalformedURLException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return listOfUrls;
    }

    public List<String> getListOfSkuWithLenght(List<String> skuList, int lenghtOfSublist) {
        List<String> listOfFiftyItemInElem = new ArrayList<>();
        do {
            int sizeOfList = skuList.size();
            listOfFiftyItemInElem.add(sizeOfList >= lenghtOfSublist ?
                    SkuUrl.addItemsToList(lenghtOfSublist, skuList) :
                    SkuUrl.addItemsToList(sizeOfList, skuList));
        } while (!skuList.isEmpty());
        return listOfFiftyItemInElem;
    }

    public List<TableObject> getHttpRequest(List<String> urls) {
        List<TableObject> objectList = new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            for (String url : urls) {
                Response response = given().get(url).thenReturn();
                String jsonResponse = response.body().asString();
                if (jsonResponse.startsWith("[")) {
                    Type listType = new TypeToken<List<TableObject>>() {
                    }.getType();
                    objectList.addAll(new Gson()
                            .fromJson(jsonResponse, listType));
                } else {
                    objectList.add(new Gson()
                            .fromJson(jsonResponse, (Type) TableObject.class));
                }
            }
        } catch (IOException ignored) {
        }
        return objectList;
    }
}


//    public <T> T getHttpRequest(List<String> urls, Object object) {
//        List<Object> objectList = new ArrayList<>();
//        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
//
//            for (String url : urls) {
//                Response response = given().get(url).thenReturn();
//                String jsonResponse = response.body().asString();
//                if (jsonResponse.startsWith("[")) {\
//                    object.getClass().getCanonicalName();
//                    Type  objectType = new TypeToken<ArrayList<object>>(){}.getType();
//                    objectList =  new Gson()
//                            .fromJson(jsonResponse,objectType);
//                } else {
//                    objectList.add(new Gson()
//                            .fromJson(jsonResponse, object.getClass()));
//                }
//            }
//        } catch (IOException ignored) {
//        }
//        return (T)objectList;
//    }
//}
