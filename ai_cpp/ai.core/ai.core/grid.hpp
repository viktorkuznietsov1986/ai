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
#include <algorithm>
#include <memory>

namespace eight_puzzle {

    typedef std::pair<int, int> point;

    enum directions {
        LEFT, RIGHT, UP, DOWN
    };

    class grid {
        static const int GRID_SIZE = 3;
        static const int EMPTY_VALUE = 0;
        
    public:
        grid(const std::vector<std::vector<int>>& state);
        grid(const grid& g);
        bool is_final_state() const;
        friend std::ostream& operator<<(std::ostream& os, const eight_puzzle::grid& g);

        std::vector<directions> get_directions() const;
        std::shared_ptr<grid> go(const directions& direction) const;
        
    private:
        bool match_with_final_state() const;
        
    private:
        std::vector<std::vector<int>> _state;
        static std::vector<std::vector<int>> _final_state;
        std::unique_ptr<point> _empty_cell;

        std::vector<std::vector<int>> void copy_current_state() const;

        bool can_go_left() const;

        bool can_go_right() const;

        bool can_go_up() const;

        bool can_go_down() const;
    };
}

#endif /* grid_hpp */
