package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.StdCusparMergeToSelect;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckLangu;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckRead;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckUsername;

public final class RootCusparSelect extends DeciTreeReadTemplate<CusparInfo> {
	
	public RootCusparSelect(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CusparCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CusparCheckUsername(checkerOption);
		queue.add(checker);
		//TODO: Adidicionar autorizacao
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		
		
		ActionStd<CusparInfo> select = new StdCusparMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}
