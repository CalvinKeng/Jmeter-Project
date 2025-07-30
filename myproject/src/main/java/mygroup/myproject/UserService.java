package mygroup.myproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
	@Autowired
	private final UserMapper userMapper;
	
	//有參數的建構子
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public UserModel getUserModelById(Integer id) {
		return userMapper.findById(id);
	}
	
	
	// 查詢一筆(使用join的)
	public List<UserModel_afterJoin> getUserModelById_byJoin(Integer id){
		UserModel_afterJoin oneResult = userMapper.findById_byJoin(id);
		// 因為報表需要配合List型別來呈現
		List<UserModel_afterJoin> result_asList = new ArrayList<UserModel_afterJoin>();
		result_asList.add(0, oneResult);
		return result_asList;
	}
	
	// 查詢多筆(原始的方法,方法名稱去除 _1 之後把新的方法註解掉,會進資料庫裏面撈資料)
	public List<UserModel> getAllUserModels_1(){
		return userMapper.findAll();
	}
	// 查詢多筆(新的方法,不進資料庫內撈資料,畫面內顯示一些假資料用的)
	public List<UserModel> getAllUserModels(){
		List<UserModel> list = new ArrayList<>();
		UserModel user_1 = new UserModel(1, "這是一個", "宇宙生物課", "章魚學", 1);
		UserModel user_2 = new UserModel(2, "暑假的實習", "海底探險", "手動挖掘大祕寶", 1);
		UserModel user_3 = new UserModel(3, "實習完成之後", "參觀新加坡或木柵動物園", "夜間動物觀察學", 1);
		UserModel user_4 = new UserModel(4, "好好放暑假", "參訪東京美術館", "美術簡史", 1);
		UserModel user_5 = new UserModel(5, "趁當學生的時候多玩", "巴塞隆納的沙灘", "如何解剖龍蝦與料理", 1);		
		list.add(user_1);
		list.add(user_2);
		list.add(user_3);
		list.add(user_4);
		list.add(user_5);
    	System.out.println("localhost 8080的頁面上會顯示xml檔案結構的資料,這些是編撰在UserService檔案內的getAllUserModels方法裡面的模擬資料,並非源自於資料庫");
		return list;
	}
	
	// (使用join的)
	public List<UserModel_afterJoin> getAllUserModels_byJoin(){
		return userMapper.findAll_byJoin();
	}
	
	
    // 新增一筆
	public void addUserModels(UserModel userModel) {
		userMapper.insertUserModel(userModel);
	}
    // 新增多筆
	public void addUserModels_list(List<UserModel> list_userModel) {
		//確認資料不是null或空清單
		if(list_userModel==null || list_userModel.isEmpty()) {
			throw new IllegalArgumentException("資料清單不可為空");
		}
		//呼叫DAO進行批量新增
		userMapper.inserUserModelBatch(list_userModel);
	}
	
	
	// 修改一筆資料
	public void updateUserModel(String name,String class_,String book,int club_id) {
		userMapper.updateUserModel(name,class_,book,club_id);
	}
}
