package br.com.mind5.business.orderSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.model.action.LazyOrdnapInsert;
import br.com.mind5.business.orderSnapshot.model.action.LazyOrdnapMergeCuslis;
import br.com.mind5.business.orderSnapshot.model.action.StdOrdnapMergeUselis;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckLangu;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckOrder;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckOwner;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrdnapInsert extends DeciTreeWriteTemplate<OrdnapInfo> {
	
	public RootOrdnapInsert(DeciTreeOption<OrdnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdnapInfo> buildDecisionCheckerHook(DeciTreeOption<OrdnapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdnapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdnapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdnapCheckOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdnapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdnapInfo> option) {
		List<ActionStd<OrdnapInfo>> actions = new ArrayList<>();

		ActionStd<OrdnapInfo> mergeUselis = new StdOrdnapMergeUselis(option);	
		ActionLazy<OrdnapInfo> mergeCuslis = new LazyOrdnapMergeCuslis(option.conn, option.schemaName);
		ActionLazy<OrdnapInfo> insert = new LazyOrdnapInsert(option.conn, option.schemaName);
		
		mergeUselis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(insert);
		
		actions.add(mergeUselis);
		return actions;
	}
}
