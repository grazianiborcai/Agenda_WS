package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cartItem.info.CartemCopier;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.RootCartemEmptfy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartEmptfyCartem extends ActionVisitorTemplateAction<CartInfo, CartemInfo> {
	public VisiCartEmptfyCartem(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class, CartemInfo.class);
	}
	
	
	
	@Override protected ActionStd<CartemInfo> getActionHook(DeciTreeOption<CartemInfo> option) {
		return new RootCartemEmptfy(option).toAction();
	}
	
	
	
	@Override protected List<CartemInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return CartemCopier.copyFromCartKey(baseInfos);
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<CartemInfo> results) {
		return baseInfos;
	}
}
