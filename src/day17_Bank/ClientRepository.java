package day17_Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ClientRepository {
	private static ClientRepository repository = new ClientRepository();

	private ClientRepository() {
	}

	public static ClientRepository getInstance() {
		return repository;
	}

	List<BreakdownDTO> bList = new ArrayList<>();
	Map<String, ClientDTO> cMap = new HashMap<>();
	//ㄴ 왼변의 <>를 오른변 <> 상 내용을 생략 가능
	// {} 중괄호의 경우, 실행문이 한 줄인경우 생략 가능

	public boolean save(ClientDTO clientDTO) {
		
		if (cMap.put(clientDTO.getAccount(), clientDTO) == null) {
			return true;         // null 자체가 입력 진행이 성공이라 true 진행
		}
		return false;
	}

	
	public boolean loginCheck(String id, String password) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getId().equals(id) && cMap.get(c).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public Map<String, ClientDTO> findAll() {
		return cMap;
	}

	
	
	public ClientDTO findById(String id, String password) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getId().equals(id) && cMap.get(c).getPassword().equals(password)) {
				return cMap.get(c);
			}
		}
		return null;
	}

	public List<BreakdownDTO> breakList(String account) {
		List<BreakdownDTO> list = new ArrayList<>();
		for (BreakdownDTO b : bList) {
			if (b.getAccount().equals(account)) {
				list.add(b);
			}
		}
		return list;
	}

	public String getAccount(String id, String password) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getId().equals(id) && cMap.get(c).getPassword().equals(password)) {
				return cMap.get(c).getAccount();
			}
		}
		return null;
	}

	public boolean deposit(String account, long money) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getAccount().equals(account)) {
				cMap.get(c).setBalance(cMap.get(c).getBalance() + money);
				BreakdownDTO breakdownDTO = new BreakdownDTO();
				breakdownDTO.setAccount(account);
				breakdownDTO.setDivision("입금");
				breakdownDTO.setDealMoney(money);
				breakdownDTO.setTotalMoney(cMap.get(c).getBalance());
				bList.add(breakdownDTO);
				return true;
			}
		}
		return false;
	}

	public boolean withdraw(String account, long money) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getAccount().equals(account)) {
				if (cMap.get(c).getBalance() >= money) {
					cMap.get(c).setBalance(cMap.get(c).getBalance() - money);
					BreakdownDTO breakdownDTO = new BreakdownDTO();
					breakdownDTO.setAccount(account);
					breakdownDTO.setDivision("출금");
					breakdownDTO.setDealMoney(money);
					breakdownDTO.setTotalMoney(cMap.get(c).getBalance());
					bList.add(breakdownDTO);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public boolean transferCheck(String transferAccount) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getAccount().equals(transferAccount)) {
				return true;
			}
		}
		return false;
	}

	public boolean update(String id, String password, String updatePassword) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getId().equals(id) && cMap.get(c).getPassword().equals(password)) {
				cMap.get(c).setPassword(updatePassword);
				return true;
			}
		}
		return false;
	}

	public boolean delete(String id, String password) {
		for (String c : cMap.keySet()) {
			if (cMap.get(c).getId().equals(id) && cMap.get(c).getPassword().equals(password)) {
				cMap.remove(c);
				return true;
			}
		}
		return false;
	}
		public boolean dupCheck(String id) {
		boolean find = false;
		while (true) {
			for (String key : cMap.keySet()) {
				if (cMap.get(key).getId().equals(id)) {
					return true;
				}
			}
			return false;
		}
	}
	
	
	
}
