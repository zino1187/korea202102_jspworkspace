package com.koreait.shoppingmall.model.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.Cart;
import com.koreait.shoppingmall.exception.DMLException;
import com.koreait.shoppingmall.model.repository.product.CartDAO;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void insert(Cart cart) throws DMLException{
		cartDAO.insert(cart);
	}

	@Override
	public List selectAll() {
		return cartDAO.selectAll();
	}

	@Override
	public List selectAllJoin(int member_id) {
		return cartDAO.selectAllJoin(member_id);
	}

	@Override
	public void update(Cart cart)  throws DMLException{
		cartDAO.update(cart);
	}

	@Override
	public void delete(int cart_id)  throws DMLException{
		cartDAO.delete(cart_id);
	}

	@Override
	public void deleteAll(int member_id)   throws DMLException{
		cartDAO.deleteAll(member_id);
	}
	
}
