package com.tjint.springboot.app.admin.jwt;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Authentication {

//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtTokenUtil;
//    private final UserDetailsService userDetailsService;
//
//    private final AuthenticationRequest authenticationRequest;
//
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getId(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect userid or password", e);
//        }
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getId());
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
}
