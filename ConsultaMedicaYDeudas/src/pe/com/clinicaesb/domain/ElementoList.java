package pe.com.clinicaesb.domain;

import java.util.Vector;

import  pe.com.clinicaesb.util.Constantes;

import net.rim.device.api.collection.util.SortedReadableList;
import net.rim.device.api.ui.component.KeywordProvider;
import net.rim.device.api.util.Comparator;

public class ElementoList  extends SortedReadableList implements KeywordProvider {
	
	Vector _data;
	
	public ElementoList(Vector data) {
		super(new BEElementoListComparator());
		this._data=data;
		loadFrom(data.elements());
	}
	
	public void addElement(int index, Object element) {
		//doAdd(element);
		insertAt(index, element);
	}
	
	public void removeElement(Object element) {
		doRemove(element);
	}

	public String[] getKeywords(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	final static class BEElementoListComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			if (o1 == null || o2 == null)
				throw new IllegalArgumentException(Constantes.MENSAJE_COMPARAR_LISTA);
			return 0;
		}
	}

}
