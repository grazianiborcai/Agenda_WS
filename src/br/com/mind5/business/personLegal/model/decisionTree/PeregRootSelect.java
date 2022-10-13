package br.com.mind5.business.personLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergeAddress;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergePerson;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergePhone;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergeToSelect;
import br.com.mind5.business.personLegal.model.checker.PeregCheckLangu;
import br.com.mind5.business.personLegal.model.checker.PeregCheckOwner;
import br.com.mind5.business.personLegal.model.checker.PeregCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PeregRootSelect extends DeciTreeTemplateRead<PeregInfo> {
	
	public PeregRootSelect(DeciTreeOption<PeregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeregInfo> buildCheckerHook(DeciTreeOption<PeregInfo> option) {
		List<ModelChecker<PeregInfo>> queue = new ArrayList<>();		
		ModelChecker<PeregInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new PeregCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new PeregCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new PeregCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeregInfo>> buildActionsOnPassedHook(DeciTreeOption<PeregInfo> option) {
		List<ActionStd<PeregInfo>> actions = new ArrayList<>();
		
		ActionStd<PeregInfo> select = new ActionStdCommom<PeregInfo>(option, PeregVisiMergeToSelect.class);
		ActionLazy<PeregInfo> mergePerson = new ActionLazyCommom<PeregInfo>(option, PeregVisiMergePerson.class);
		ActionLazy<PeregInfo> mergeAddress = new ActionLazyCommom<PeregInfo>(option, PeregVisiMergeAddress.class);
		ActionLazy<PeregInfo> mergePhone = new ActionLazyCommom<PeregInfo>(option, PeregVisiMergePhone.class);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		
		actions.add(select);
		return actions;
	}
}
