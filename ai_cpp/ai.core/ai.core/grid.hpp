//
//  grid.hpp
//  ai.core
//
//  Created by Viktor Kuznietsov on 7/5/17.
//  Copyright © 2017 Viktor Kuznietsov. All rights reserved.
//

#ifndef grid_hpp
#define grid_hpp

#include <stdio.h>
#include <vector>
#include <iostream>

namespace eight_puzzle {
    class grid {
        static const int GRID_SIZE = 3;
        static const int EMPTY_VALUE = 0;
        
    public:
        grid(const std::vector<std::vector<int>>& state);
        bool is_final_state() const;
        friend std::ostream& operator<<(std::ostream& os, const eight_puzzle::grid& g);
        
    private:
        bool match_with_final_state() const;
        
    private:
        std::vector<std::vector<int>> _state;
        static std::vector<std::vector<int>> _final_state;
    };
}

#endif /* grid_hpp */
