package br.com.mind5.payment.customerPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.action.StdCusparchMergeToSelect;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckOwner;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckRead;

public final class RootCusparchSelect extends DeciTreeReadTemplate<CusparchInfo> {
	
	public RootCusparchSelect(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparchInfo> buildCheckerHook(DeciTreeOption<CusparchInfo> option) {
		List<ModelChecker<CusparchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusparchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusparchCheckOwner(checkerOption);
		queue.add(checker);
		

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusparchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparchInfo> option) {
		List<ActionStdV1<CusparchInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<CusparchInfo> select = new StdCusparchMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}
