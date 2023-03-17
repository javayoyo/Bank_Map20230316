package day17_Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day15_20230314_2.BoardDTO;

public class ClientRepository {
	private static ClientRepository repository = new ClientRepository();

	private ClientRepository() {
	}

	public static ClientRepository getInstance() {
		return repository;
	}

	List<BreakdownDTO> bList = new ArrayList<>();
	Map<String, ClientDTO> cMap = new HashMap<>();

	public boolean save(ClientDTO clientDTO) {
		
		if (cMap.put(clientDTO.getId(), clientDTO) == null) {
			return true; // null 자체가 입력 진행이 성공이라 true 진행
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
		for (ClientDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				return c;
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
		for (ClientDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				return c.getAccount();
			}
		}
		return null;
	}

	public boolean deposit(String account, long money) {
		for (ClientDTO c : cList) {
			if (c.getAccount().equals(account)) {
				c.setBalance(c.getBalance() + money);
				BreakdownDTO breakdownDTO = new BreakdownDTO();
				breakdownDTO.setAccount(account);
				breakdownDTO.setDivision("입금");
				breakdownDTO.setDealMoney(money);
				breakdownDTO.setTotalMoney(c.getBalance());
				bList.add(breakdownDTO);
				return true;
			}
		}
		return false;
	}

	public boolean withdraw(String account, long money) {
		for (ClientDTO c : cList) {
			if (c.getAccount().equals(account)) {
				if (c.getBalance() >= money) {
					c.setBalance(c.getBalance() - money);
					BreakdownDTO breakdownDTO = new BreakdownDTO();
					breakdownDTO.setAccount(account);
					breakdownDTO.setDivision("출금");
					breakdownDTO.setDealMoney(money);
					breakdownDTO.setTotalMoney(c.getBalance());
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
		for (ClientDTO c : cList) {
			if (c.getAccount().equals(transferAccount)) {
				return true;
			}
		}
		return false;
	}

	public boolean update(String id, String password, String updatePassword) {
		for (ClientDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				c.setPassword(updatePassword);
				return true;
			}
		}
		return false;
	}

	public boolean delete(String id, String password) {
		for (ClientDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				cList.remove(c);
				return true;
			}
		}
		return false;
	}
}
