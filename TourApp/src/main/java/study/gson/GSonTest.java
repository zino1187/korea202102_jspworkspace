package study.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class GSonTest {

	//과일의 목록을 표현한 json 문자열을 출력
	public static void main(String[] args) {
		//순서있는것(List), 순서없는것(Set),  key-value쌍(Map)
		Map<String, List> map=new HashMap<String, List>();
		
		
		//리스트를 생성하여 그 안에 vo의 인스턴스 넣기!
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		Fruit f1 = new Fruit();
		Fruit f2 = new Fruit();
		Fruit f3 = new Fruit();
		
		f1.setName("사과");
		f1.setPrice(5000);
		
		f2.setName("오렌지");
		f2.setPrice(7000);
		
		f3.setName("블루베리");
		f3.setPrice(10000);
		list.add(f1);
		list.add(f2);
		list.add(f3);
		
		//맵에 넣기 
		map.put("fruitList", list);
		
		//자바의 객체 구성이 끝났다면 지금부터는 Gson 에게 맡기자!
		Gson gson=new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
	}
}








