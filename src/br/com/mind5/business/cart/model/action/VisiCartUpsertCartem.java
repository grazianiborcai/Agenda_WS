package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cartItem.info.CartemCopier;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.RootCartemUpsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartUpsertCartem extends ActionVisitorTemplateActionV1<CartInfo, CartemInfo> {
	public VisiCartUpsertCartem(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class, CartemInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CartemInfo> getActionHook(DeciTreeOption<CartemInfo> option) {
		return new RootCartemUpsert(option).toAction();
	}
	
	
	
	@Override protected List<CartemInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return CartemCopier.copyFromCart(baseInfos);
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<CartemInfo> results) {
		return baseInfos;
	}
}
