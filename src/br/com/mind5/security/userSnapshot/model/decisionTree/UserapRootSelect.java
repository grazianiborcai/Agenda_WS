package br.com.mind5.security.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.action.UserapVisiMergeAddresnap;
import br.com.mind5.security.userSnapshot.model.action.UserapVisiMergePersonap;
import br.com.mind5.security.userSnapshot.model.action.UserapVisiMergePhonap;
import br.com.mind5.security.userSnapshot.model.action.UserapVisiMergeToSelect;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckRead;

public final class UserapRootSelect extends DeciTreeTemplateRead<UserapInfo> {
	
	public UserapRootSelect(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserapInfo> buildCheckerHook(DeciTreeOption<UserapInfo> option) {
		List<ModelChecker<UserapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserapCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserapInfo>> buildActionsOnPassedHook(DeciTreeOption<UserapInfo> option) {
		List<ActionStd<UserapInfo>> actions = new ArrayList<>();
		
		ActionStd<UserapInfo> select = new ActionStdCommom<UserapInfo>(option, UserapVisiMergeToSelect.class);
		ActionLazy<UserapInfo> mergePerson = new ActionLazyCommom<UserapInfo>(option, UserapVisiMergePersonap.class);
		ActionLazy<UserapInfo> mergeAddress = new ActionLazyCommom<UserapInfo>(option, UserapVisiMergeAddresnap.class);
		ActionLazy<UserapInfo> mergePhone = new ActionLazyCommom<UserapInfo>(option, UserapVisiMergePhonap.class);
		//TODO: PersonCus nao vem do snapshot. Corrigir isso
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		
		actions.add(select);
		return actions;
	}
}
