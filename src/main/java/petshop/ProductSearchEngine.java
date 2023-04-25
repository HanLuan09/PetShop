package petshop;

import java.util.*;
import java.sql.*;

public class ProductSearchEngine {
    
    // Tiền xử lý dữ liệu sản phẩm
    public static String preprocess(String text) {
        // Chuẩn hóa chuỗi, xóa các ký tự đặc biệt, tách từ khóa và xóa stop words
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
        List<String> stopWords = Arrays.asList("a", "an", "the", "and", "but", "or", "for", "nor", "on", "at", "to", "from", "by", "of", "in", "cho");
        List<String> filteredWords = new ArrayList<String>();
        for (String word : words) {
            if (!stopWords.contains(word)) {
                filteredWords.add(word);
            }
        }
        return String.join(" ", filteredWords);
    }
    
    // Tách từ khóa trong câu truy vấn
    public static List<String> tokenize(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        return Arrays.asList(words);
    }
    
    // Đánh điểm tương đồng sử dụng cosine similarity
    public static double cosineSimilarity(Map<String, Double> queryVector, Map<String, Double> productVector) {
        double dotProduct = 0.0;
        double queryNorm = 0.0;
        double productNorm = 0.0;
        for (Map.Entry<String, Double> queryEntry : queryVector.entrySet()) {
            String queryTerm = queryEntry.getKey();
            Double queryWeight = queryEntry.getValue();
            Double productWeight = productVector.get(queryTerm);
            if (productWeight != null) {
                dotProduct += queryWeight * productWeight;
            }
            queryNorm += queryWeight * queryWeight;
        }
        for (Double productWeight : productVector.values()) {
            productNorm += productWeight * productWeight;
        }
        double denominator = Math.sqrt(queryNorm) * Math.sqrt(productNorm);
        if (denominator == 0.0) {
            return 0.0;
        } else {
            return dotProduct / denominator;
        }
    }
    
    // Sắp xếp và trả về kết quả tìm kiếm
//    public static List<String> search(String query, Connection connection) throws SQLException {
    public static List<String> serach(String query, List<String> list){
        // Tiền xử lý câu truy vấn
        String preprocessedQuery = preprocess(query);
        List<String> queryTokens = tokenize(preprocessedQuery);
        Map<String, Double> queryVector = new HashMap<String, Double>();
        for (String token : queryTokens) {
            double tf = 1.0 + Math.log10(Collections.frequency(queryTokens, token));
            double idf = 1.0;
            queryVector.put(token, tf * idf);
        }
        // Lấy dữ liệu sản phẩm từ cơ sở dữ liệu
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT name FROM products");
        List<String> productNames = new ArrayList<String>();
//        while (resultSet.next()) {
        for(String o: list) {
//            String productName = resultSet.getString("name");
            // Tiền xử lý dữ liệu sản phẩm
        	String productName = o;
            String preprocessedProductName = preprocess(productName);
            // Tạo vector cho từng sản phẩm
            List<String> productTokens = tokenize(preprocessedProductName);
            Map<String, Double> productVector = new HashMap<String, Double>();
            for (String token : productTokens) {
	            double tf = 1.0 + Math.log10(Collections.frequency(productTokens, token));
	            double idf = 1.0;
	            productVector.put(token, tf * idf);
            }
            // Đánh giá tương đồng giữa câu truy vấn và từng sản phẩm
            double similarityScore = cosineSimilarity(queryVector, productVector);
            if (similarityScore > 0.0) {
            	productNames.add(productName);
            }
        }
            // Sắp xếp kết quả theo mức độ phù hợp với truy vấn và trả về kết quả cho người dùng
        Collections.sort(productNames, new Comparator<String>() {
            public int compare(String name1, String name2) {
	            String preprocessedName1 = preprocess(name1);
	            String preprocessedName2 = preprocess(name2);
	            List<String> name1Tokens = tokenize(preprocessedName1);
	            List<String> name2Tokens = tokenize(preprocessedName2);
	            double similarityScore1 = cosineSimilarity(queryVector, vectorize(name1Tokens));
	            double similarityScore2 = cosineSimilarity(queryVector, vectorize(name2Tokens));
	            return Double.compare(similarityScore2, similarityScore1);
            }
        });
        return productNames;
    }
 // Tạo vector cho một danh sách các từ khóa
    public static Map<String, Double> vectorize(List<String> tokens) {
        Map<String, Double> vector = new HashMap<String, Double>();
        for (String token : tokens) {
            double tf = 1.0 + Math.log10(Collections.frequency(tokens, token));
            double idf = 1.0;
            vector.put(token, tf * idf);
        }
        return vector;
    }

//    public static void main(String[] args) throws SQLException {
//        // Kết nối cơ sở dữ liệu
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "user", "password");
//        // Tìm kiếm sản phẩm
//        List<String> results = search("áo thun trắng", connection);
//        // In kết quả
//        for (String result : results) {
//            System.out.println(result);
//        }
//        // Đóng kết nối cơ sở dữ liệu
//        connection.close();
//    }
}
