package br.com.mind5.payment.customerPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.action.CusparchVisiMergeToSelect;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckOwner;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckRead;

public final class CusparchRootSelect extends DeciTreeTemplateRead<CusparchInfo> {
	
	public CusparchRootSelect(DeciTreeOption<CusparchInfo> option) {
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
		

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparchInfo> option) {
		List<ActionStd<CusparchInfo>> actions = new ArrayList<>();		
		
		ActionStd<CusparchInfo> select = new ActionStdCommom<CusparchInfo>(option, CusparchVisiMergeToSelect.class);
		
		actions.add(select);			
		return actions;
	}
}
