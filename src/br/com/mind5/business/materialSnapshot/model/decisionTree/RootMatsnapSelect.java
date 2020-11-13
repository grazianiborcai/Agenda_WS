package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMateg;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatextsnap;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatoup;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatubup;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatunit;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatype;
import br.com.mind5.business.materialSnapshot.model.action.StdMatsnapMergeToSelect;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckMat;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatsnapSelect extends DeciTreeTemplateRead<MatsnapInfo> {
	
	public RootMatsnapSelect(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatsnapInfo> buildCheckerHook(DeciTreeOption<MatsnapInfo> option) {
		List<ModelChecker<MatsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatsnapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStd<MatsnapInfo>> actions = new ArrayList<>();
		
		ActionStd<MatsnapInfo> select = new StdMatsnapMergeToSelect(option);
		ActionLazy<MatsnapInfo> mergeMatextsnap = new LazyMatsnapMergeMatextsnap(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatype = new LazyMatsnapMergeMatype(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMateg = new LazyMatsnapMergeMateg(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatoup = new LazyMatsnapMergeMatoup(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatubup = new LazyMatsnapMergeMatubup(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatunit = new LazyMatsnapMergeMatunit(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatextsnap);
		mergeMatextsnap.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatoup);
		mergeMatoup.addPostAction(mergeMatubup);
		mergeMatubup.addPostAction(mergeMatunit);
		
		actions.add(select);
		return actions;
	}
}
