package com.paulocorreaslz.tjma.util;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
public enum TipoInsumo {
	MAODEOBRA,
	MATERIAL,
	COMPOSTO;
	
	@Override
    public String toString() {
        return name();
    }
}
