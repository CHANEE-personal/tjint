(function($) {
    $(function() {
        var jcarousel = $('.jcarousel');

        jcarousel
            .on('jcarousel:reload jcarousel:create', function () {
                var width = jcarousel.innerWidth();

                if (width >= 900) {
                    width = width / 4;
                } else if (width >= 600) {
                    width = width / 3;
                } else if (width >= 400) {
                    width = width / 2;
                }

                jcarousel.jcarousel('items').css('width', width + 'px');
            })
            .jcarousel({
                wrap: 'circular'
            });

        $('.jcarousel-control-prev')
            .jcarouselControl({
                target: '-=1'
            });

        $('.jcarousel-control-next')
            .jcarouselControl({
                target: '+=1'
            });

        $('.jcarousel-pagination')
            .on('jcarouselpagination:active', 'a', function() {
                $(this).addClass('active');
            })
            .on('jcarouselpagination:inactive', 'a', function() {
                $(this).removeClass('active');
            })
            .on('click', function(e) {
                e.preventDefault();
            })
            .jcarouselPagination({
                perPage: 1,
                item: function(page) {
                    return '<a href="#' + page + '">' + page + '</a>';
                }
            });

        $.jCarousel.plugin('jcarouselAutoscroll', {
            _options: {
                target:    '+=1',
                interval:  3000,
                autostart: true
            },
            _timer: null,
            _init: function () {
                this.onDestroy = $.proxy(function() {
                    this._destroy();
                    this.carousel()
                        .one('jcarousel:createend', $.proxy(this._create, this));
                }, this);

                this.onAnimateEnd = $.proxy(this.start, this);
            },
            _create: function() {
                this.carousel()
                    .one('jcarousel:destroy', this.onDestroy);

                if (this.options('autostart')) {
                    this.start();
                }
            },
            _destroy: function() {
                this.stop();
                this.carousel()
                    .off('jcarousel:destroy', this.onDestroy);
            },
            start: function() {
                this.stop();

                this.carousel()
                    .one('jcarousel:animateend', this.onAnimateEnd);

                this._timer = setTimeout($.proxy(function() {
                    this.carousel().jcarousel('scroll', this.options('target'));
                }, this), this.options('interval'));

                return this;
            },
            stop: function() {
                if (this._timer) {
                    this._timer = clearTimeout(this._timer);
                }

                this.carousel()
                    .off('jcarousel:animateend', this.onAnimateEnd);

                return this;
            }
        });
    });
})(jQuery);
