package br.com.mind5.security.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.action.LazyUserapMergeAddresnap;
import br.com.mind5.security.userSnapshot.model.action.LazyUserapMergePersonap;
import br.com.mind5.security.userSnapshot.model.action.LazyUserapMergePhonap;
import br.com.mind5.security.userSnapshot.model.action.StdUserapMergeToSelect;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckRead;

public final class RootUserapSelect extends DeciTreeReadTemplate<UserapInfo> {
	
	public RootUserapSelect(DeciTreeOption<UserapInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserapInfo>> buildActionsOnPassedHook(DeciTreeOption<UserapInfo> option) {
		List<ActionStdV1<UserapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UserapInfo> select = new StdUserapMergeToSelect(option);
		ActionLazyV1<UserapInfo> mergePerson = new LazyUserapMergePersonap(option.conn, option.schemaName);
		ActionLazyV1<UserapInfo> mergeAddress = new LazyUserapMergeAddresnap(option.conn, option.schemaName);
		ActionLazyV1<UserapInfo> mergePhone = new LazyUserapMergePhonap(option.conn, option.schemaName);
		//TODO: PersonCus nao vem do snapshot. Corrigir isso
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		
		actions.add(select);
		return actions;
	}
}
