package org.javasoft.demoapi.util;

import org.springframework.data.domain.Sort;

public class SortUtil {

    public static Sort handleSort(boolean sortNameASC , boolean sortGenderASC , boolean sortSpeciesASC){
        Sort genderSort = sortGenderASC ? Sort.by("gender").ascending() : Sort.by("gender").descending();
        Sort nameSort = sortNameASC ? Sort.by("name").ascending() : Sort.by("name").descending();
        Sort speciesSort = sortSpeciesASC ? Sort.by("species").ascending() : Sort.by("species").descending();
        return genderSort.and(nameSort).and(speciesSort);
    }
}
