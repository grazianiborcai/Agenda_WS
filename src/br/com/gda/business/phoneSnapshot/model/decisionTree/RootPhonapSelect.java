package br.com.gda.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.action.LazyPhonapMergeCountryPhone;
import br.com.gda.business.phoneSnapshot.model.action.LazyPhonapMergeForm;
import br.com.gda.business.phoneSnapshot.model.action.StdPhonapSelect;
import br.com.gda.business.phoneSnapshot.model.checker.PhonapCheckLangu;
import br.com.gda.business.phoneSnapshot.model.checker.PhonapCheckOwner;
import br.com.gda.business.phoneSnapshot.model.checker.PhonapCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootPhonapSelect extends DeciTreeReadTemplate<PhonapInfo> {

	public RootPhonapSelect(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonapInfo> buildDecisionCheckerHook(DeciTreeOption<PhonapInfo> option) {
		List<ModelChecker<PhonapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhonapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhonapCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStd<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonapInfo> select = new StdPhonapSelect(option);	
		ActionLazy<PhonapInfo> mergeCountryPhone = new LazyPhonapMergeCountryPhone(option.conn, option.schemaName);
		ActionLazy<PhonapInfo> mergeForm = new LazyPhonapMergeForm(option.conn, option.schemaName);

		select.addPostAction(mergeCountryPhone);	
		mergeCountryPhone.addPostAction(mergeForm);
		
		actions.add(select);
		
		return actions;
	}
}
