package br.com.gda.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparNodeInsertMoip;
import br.com.gda.payment.customerPartner.model.action.StdCusparInsert;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckPhonapUser;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckAddresnapUser;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusparInsert extends DeciTreeWriteTemplate<CusparInfo> {
	
	public NodeCusparInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		
		checker = new CusparCheckAddresnapUser();
		queue.add(checker);
		
		checker = new CusparCheckPhonapUser();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd<CusparInfo> insert = new StdCusparInsert(option);
		ActionLazy<CusparInfo> insertMoip = new LazyCusparNodeInsertMoip(option.conn, option.schemaName);
		
		insert.addPostAction(insertMoip);
		
		actions.add(insert);
		return actions;
	}
}
