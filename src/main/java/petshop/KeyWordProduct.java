package petshop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.DAO;
import model.Category;

public class KeyWordProduct {
	public Set<String> getKey(){
		DAO dao = new DAO();
		List<Category> listC = dao.getAllCategory();
		String[] s1 = {"Súp", "Súp thưởng", "Thưởng cho chó", "Thưởng cho mèo", "Súp thưởng cho chó", "Súp thưởng cho mèo", "Súp ăn liền",
				"Súp ăn liền cho chó","Súp ăn liền cho chó", "Bánh thưởng", "Bánh thưởng cho chó", "Bánh thưởng cho mèo",
				"Chó", "Mèo",
				"Thức ăn", "Thức ăn cho chó", "Thức ăn cho mèo",
				"Thuốc", 
				"Dụng cụ",
				"Đồ dùng"
				};
		Set<String> set = new HashSet<>();
		for(String i: s1) set.add(i);
		for(Category o: listC) set.add(o.getCname());
		return set;
	}
}
