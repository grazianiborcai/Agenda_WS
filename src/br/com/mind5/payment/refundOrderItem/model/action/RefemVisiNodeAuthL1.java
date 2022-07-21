package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.decisionTree.RefemNodeAuthL1;

public final class RefemVisiNodeAuthL1 extends ActionVisitorTemplateAction<RefemInfo, RefemInfo> {

	public RefemVisiNodeAuthL1(DeciTreeOption<RefemInfo> option) {
		super(option, RefemInfo.class, RefemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefemInfo>> getTreeClassHook() {
		return RefemNodeAuthL1.class;
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<RefemInfo> results) {
		return results;
	}
}
