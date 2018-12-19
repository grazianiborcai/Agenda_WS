package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class CartMergerUser extends InfoMerger<CartInfo, UserInfo, CartInfo> {
	public CartInfo merge(UserInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorUser());
	}
	
	
	
	public List<CartInfo> merge(List<UserInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorUser());
	}
}
