package br.com.mind5.payment.countryPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;
import br.com.mind5.payment.countryPartnerSearch.model.action.CounparchVisiDaoSelect;
import br.com.mind5.payment.countryPartnerSearch.model.checker.CounparchCheckRead;

public final class CounparchRootSelect extends DeciTreeTemplateRead<CounparchInfo> {
	
	public CounparchRootSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CounparchInfo> buildCheckerHook(DeciTreeOption<CounparchInfo> option) {
		List<ModelChecker<CounparchInfo>> queue = new ArrayList<>();		
		ModelChecker<CounparchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CounparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CounparchInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparchInfo> option) {
		List<ActionStd<CounparchInfo>> actions = new ArrayList<>();
		
		ActionStd<CounparchInfo> select = new ActionStdCommom<CounparchInfo>(option, CounparchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
