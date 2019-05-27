package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cartItem.info.CartemCopier;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.decisionTree.RootCartemUpsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartUpsertCartem extends ActionVisitorTemplateAction<CartInfo, CartemInfo> {
	public VisiCartUpsertCartem(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class, CartemInfo.class);
	}
	
	
	
	@Override protected ActionStd<CartemInfo> getActionHook(DeciTreeOption<CartemInfo> option) {
		return new RootCartemUpsert(option).toAction();
	}
	
	
	
	@Override protected List<CartemInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return CartemCopier.copyFromCart(baseInfos);
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<CartemInfo> results) {
		return baseInfos;
	}
}
