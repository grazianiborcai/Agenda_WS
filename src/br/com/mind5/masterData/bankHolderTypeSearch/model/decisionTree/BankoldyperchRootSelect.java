package br.com.mind5.masterData.bankHolderTypeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.bankHolderTypeSearch.info.BankoldyperchInfo;
import br.com.mind5.masterData.bankHolderTypeSearch.model.action.BankoldyperchVisiDaoSelect;
import br.com.mind5.masterData.bankHolderTypeSearch.model.checker.BankoldyperchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankoldyperchRootSelect extends DeciTreeTemplateRead<BankoldyperchInfo> {
	
	public BankoldyperchRootSelect(DeciTreeOption<BankoldyperchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankoldyperchInfo> buildCheckerHook(DeciTreeOption<BankoldyperchInfo> option) {
		List<ModelChecker<BankoldyperchInfo>> queue = new ArrayList<>();		
		ModelChecker<BankoldyperchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankoldyperchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BankoldyperchInfo>> buildActionsOnPassedHook(DeciTreeOption<BankoldyperchInfo> option) {
		List<ActionStd<BankoldyperchInfo>> actions = new ArrayList<>();
		
		ActionStd<BankoldyperchInfo> select = new ActionStdCommom<BankoldyperchInfo>(option, BankoldyperchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
