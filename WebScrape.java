import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrape {
    public static void main(String[] args) {
        final String url = "https://www.imdb.com/chart/top";
        try {
            Document document = Jsoup.connect(url).timeout(6000).get();
            Elements element = document.select("tbody.lister-list");
            for (Element e : element.select("tr")){
                //String img = e.select("td.posterColumn img").attr("src");
                String title = e.select("td.posterColumn img").attr("alt");
                String year = e.select("td.titleColumn span.secondaryInfo")
                    .text()
                    .replaceAll("[^\\d]", "");
                String rate = e.select("td.ratingColumn.imdbRating").text();
                System.out.println(year);
                System.out.println(rate);
                System.out.println(title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
